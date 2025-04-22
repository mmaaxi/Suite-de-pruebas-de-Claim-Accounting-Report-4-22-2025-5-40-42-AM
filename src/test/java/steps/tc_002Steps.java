package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.tc_002Page;
import org.junit.Assert;

public class tc_002Steps {
    tc_002Page page = new tc_002Page();

    @Given("I have logged into the application")
    public void i_have_logged_into_the_application() {
        page.loginToApplication();
    }

    @When("I export the 'Claim Accounting Report'")
    public void i_export_the_claim_accounting_report() {
        page.exportClaimAccountingReport();
    }

    @Then("the report should be downloaded successfully")
    public void the_report_should_be_downloaded_successfully() {
        Assert.assertTrue(page.isReportDownloaded());
    }

    @Then("the 'Estado Código' column should be correctly positioned in the Excel file")
    public void the_estado_codigo_column_should_be_correctly_positioned_in_the_excel_file() {
        Assert.assertTrue(page.isEstadoCodigoColumnCorrectlyPositioned());
    }
}