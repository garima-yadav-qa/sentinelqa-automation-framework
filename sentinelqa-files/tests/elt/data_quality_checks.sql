-- dbt-style data-quality assertions for the subscriptions model.
-- Each query must return zero rows to pass.

-- 1. Uniqueness: subscription_id must be unique
SELECT subscription_id, COUNT(*) AS dup_count
FROM dw.fct_subscriptions
GROUP BY subscription_id
HAVING COUNT(*) > 1;

-- 2. Not null: critical columns must be populated
SELECT COUNT(*) AS null_rows
FROM dw.fct_subscriptions
WHERE customer_id IS NULL
   OR plan IS NULL
   OR status IS NULL;

-- 3. Referential integrity: every customer_id exists in dim_customer
SELECT f.customer_id
FROM dw.fct_subscriptions f
LEFT JOIN dw.dim_customer d ON f.customer_id = d.customer_id
WHERE d.customer_id IS NULL;

-- 4. Salesforce CRM match: warehouse plan must equal the synced CRM plan
SELECT f.subscription_id, f.plan AS warehouse_plan, c.plan AS crm_plan
FROM dw.fct_subscriptions f
JOIN crm.sf_account c ON f.customer_id = c.customer_id
WHERE f.plan <> c.plan;
