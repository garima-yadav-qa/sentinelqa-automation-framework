-- Source-to-target row reconciliation: application DB vs data warehouse.
-- The CI job fails if the counts drift apart.

SELECT
    s.cnt           AS source_rows,
    t.cnt           AS warehouse_rows,
    s.cnt - t.cnt   AS diff
FROM (SELECT COUNT(*) AS cnt FROM app.subscriptions)    s,
     (SELECT COUNT(*) AS cnt FROM dw.fct_subscriptions) t;

-- Expectation: diff = 0
