# SentinelQA — AI-Augmented Test Automation Framework

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4-43B02A)
![Playwright](https://img.shields.io/badge/Playwright-Python-2EAD33)
![REST Assured](https://img.shields.io/badge/API-REST%20Assured-success)
![CI](https://img.shields.io/badge/CI-GitHub%20Actions-2088FF)
![AI in QA](https://img.shields.io/badge/AI--assisted-QA-16A36B)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

A self-directed, 30-day QA / SDET case study: end-to-end test automation for a Salesforce-integrated SaaS subscription platform — from test strategy to a green CI gate, with AI woven across the lifecycle.

### 🔗 Live walkthrough → https://garimayadav-sentinelqa.netlify.app

---

## What it covers
- **Test strategy** — risk-based approach, test pyramid, requirements traceability matrix (RTM)
- **UI automation** — Selenium (Java, TestNG, Page Object Model) + Playwright (Python)
- **API automation** — REST Assured: status, schema and contract validation
- **Data / ELT testing** — source-to-target reconciliation across app, Salesforce and warehouse, with dbt-style data-quality assertions
- **CI/CD** — GitHub Actions pipeline that runs the full suite on every pull request and blocks bad builds
- **AI-assisted QA** — test-case generation, self-healing locators, AI defect triage, visual regression, risk-based test selection
- **Performance** — JMeter and k6 load checks
- **Reporting** — Allure reports and quality-metrics dashboards

## Framework design
- **Tests layer** — Cucumber BDD feature files, readable by the whole team
- **Page objects & API clients** — locators and endpoints kept out of the tests
- **Core** — driver factory, environment config, test-data builders
- **Execution** — parallel, cross-browser, on every pull request
- **Reporting** — Allure with screenshots, logs and trends

## Results (illustrative)
| Metric | Result |
| --- | --- |
| Automated tests | 312 |
| Automated coverage | 86% |
| Regression time | 2 days → 38 min |
| Defect escape rate | −60% |
| Pass rate | 99% |

## Tech stack
Java · Selenium 4 · TestNG · Cucumber BDD · Playwright (Python) · REST Assured · Postman · SQL · JMeter · k6 · GitHub Actions · Jenkins · JIRA · Allure · AI-assisted testing · Azure DevOps

---

*Self-directed case study built on a representative SaaS application; results are illustrative.*
*Kumari Garima Yadav — Senior QA Consultant / SDET · [LinkedIn](https://linkedin.com/in/garima-yadav-3004)*
