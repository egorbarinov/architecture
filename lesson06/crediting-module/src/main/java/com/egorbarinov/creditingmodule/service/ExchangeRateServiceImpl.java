package com.egorbarinov.creditingmodule.service;

import com.egorbarinov.creditingmodule.dto.ValuteDto;
import com.egorbarinov.creditingmodule.entities.ExchangeRate;
import com.egorbarinov.creditingmodule.entities.Valute;
import com.egorbarinov.creditingmodule.mapper.ValuteMapper;
import com.egorbarinov.creditingmodule.registry.IdentityMap;
import com.egorbarinov.creditingmodule.registry.Registry;
import com.egorbarinov.creditingmodule.repository.ExchangeRateRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;


@Service
@EnableScheduling
public class ExchangeRateServiceImpl implements ExchangeRateService{

    private final ValuteMapper mapper = ValuteMapper.MAPPER;

    private ExchangeRateRepository exchangeRateRepository;

    private IdentityMap identityMap = new IdentityMap();

    private final static Logger logger = LoggerFactory.getLogger(ExchangeRate.class);

    @Autowired
    public void setExchangeRateRepository(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;

    }

    @Override
    public List<ValuteDto> getAll() {
        LocalDate date =LocalDate.now();

        List<ValuteDto> lists = mapper.fromValuteList(exchangeRateRepository.findExchangeRateByDate(date).getValutes());

        System.out.println(identityMap.findAll()); // здесь показал, что identityMap хранит  сессионный кеш данных.

        lists.sort(Comparator.comparing(ValuteDto::getName));
        return lists;
    }

    @Override
    public ValuteDto findById() {
        return null;
    }

    @Override
    @Scheduled(cron = "0 0/30 7-15 * * MON-FRI")
    public void processingHttpRequest() throws IOException {
        if (exchangeRateRepository.findExchangeRateByDate(LocalDate.now()) == null) {
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + LocalDate.now().format(formatters));

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                saveToExchangeRate(url, LocalDate.now());
            }
        }
    }

    private void saveToExchangeRate(URL url, LocalDate date) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();

        ExchangeRate rate = xmlMapper.readValue(url, ExchangeRate.class);
        rate.setDate(date);
        identityMap.add(rate);
        exchangeRateRepository.save(rate);
        logger.info("All records rates for today is saved! ");
    }

}
