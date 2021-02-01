package com.egorbarinov.creditingmodule.service;

import com.egorbarinov.creditingmodule.dto.ValuteDto;
import java.io.IOException;
import java.util.List;

public interface ExchangeRateService {

    void processingHttpRequest() throws IOException;
    List<ValuteDto> getAll();
    ValuteDto findById();

}
