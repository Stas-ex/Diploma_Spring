package com.diplom.black_fox_ex.response;

public class ProfileViewHiDtoResponse {
    String error;
    HistoryDto historyDto;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HistoryDto getHistoryDto() {
        return historyDto;
    }

    public void setHistoryDto(HistoryDto historyDto) {
        this.historyDto = historyDto;
    }
}