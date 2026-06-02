# Event Backbone

Shared event contracts live in `platform/event-schema`.

Initial topics:
- `order.submitted`
- `order.canceled`
- `order.matched`
- `trade.executed`
- `balance.changed`
- `clearing.completed`
- `market.depth.updated`
- `market.kline.generated`
- `risk.alerted`
- `wallet.deposit.confirmed`
- `wallet.withdraw.approved`
- `futures.mark-price.updated`
- `futures.liquidation.triggered`

Events use `EventEnvelope<T>` with sequence, aggregate id, and idempotency key fields to support replay and ordered processing.
