package lotto.domain.dto.response;

public class LottoTicketsCountResponse {
    private final int manualTicketsCount;
    private final int autoTicketsCount;

    public LottoTicketsCountResponse(final int manualTicketsCount, int autoTicketsCount) {
        this.manualTicketsCount = manualTicketsCount;
        this.autoTicketsCount = autoTicketsCount;
    }

    public int getManualTicketsCount() {
        return manualTicketsCount;
    }

    public int getAutoTicketsCount() {
        return autoTicketsCount;
    }
}
