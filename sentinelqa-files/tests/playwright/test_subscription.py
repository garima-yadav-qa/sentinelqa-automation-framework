"""Playwright UI checks for the subscription upgrade flow."""
import os

import pytest
from playwright.sync_api import expect

BASE_URL = os.getenv("BASE_URL", "https://app.example.test")


@pytest.mark.regression
def test_upgrade_flow(page):
    page.goto(f"{BASE_URL}/plans")
    page.get_by_test_id("pro").click()
    page.get_by_test_id("upgrade").click()
    expect(page.get_by_test_id("plan")).to_have_text("Pro")


@pytest.mark.regression
def test_invoice_is_prorated(page):
    page.goto(f"{BASE_URL}/plans")
    page.get_by_test_id("pro").click()
    page.get_by_test_id("upgrade").click()
    invoice = page.get_by_test_id("next-invoice").inner_text()
    amount = float("".join(c for c in invoice if c.isdigit() or c == "."))
    assert amount > 0
