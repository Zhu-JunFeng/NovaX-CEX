package com.novax.cex.events.core;

public final class TopicNames {
    public static final String ORDER_SUBMITTED = "order.submitted";
    public static final String ORDER_CANCELED = "order.canceled";
    public static final String ORDER_MATCHED = "order.matched";
    public static final String TRADE_EXECUTED = "trade.executed";
    public static final String BALANCE_CHANGED = "balance.changed";
    public static final String CLEARING_COMPLETED = "clearing.completed";
    public static final String MARKET_DEPTH_UPDATED = "market.depth.updated";
    public static final String MARKET_KLINE_GENERATED = "market.kline.generated";
    public static final String RISK_ALERTED = "risk.alerted";
    public static final String WALLET_DEPOSIT_CONFIRMED = "wallet.deposit.confirmed";
    public static final String WALLET_WITHDRAW_APPROVED = "wallet.withdraw.approved";
    public static final String FUTURES_MARK_PRICE_UPDATED = "futures.mark-price.updated";
    public static final String FUTURES_LIQUIDATION_TRIGGERED = "futures.liquidation.triggered";

    private TopicNames() {
    }
}
