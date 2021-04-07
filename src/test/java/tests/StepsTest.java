package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.Page;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsTest {

    Page po = new Page();

    @Step("Open GitHub URL")
    public void openMainPage() {
        open(po.githubUrl);
    }

    @Step("Search for Allure Repository")
    public void searchRepo() {
        $(po.headerSearchInput).setValue(po.repoPath).pressEnter();

    }

    @Step("Click on a Repository link")
    public void clickRepo() {
        $(By.linkText(po.repoPath)).click();
    }

    @Step("Click on an Issues tab")
    public void clickOnIssuesTab() {
        $(withText(po.issuesTab)).click();

    }

    @Step("Issue number existence validation")
    public void issueNumberValidation() {
        $(withText(po.issueNumber)).shouldBe(Condition.visible);

    }

    @Test
    void searchIssueWithSteps() {
        openMainPage();
        searchRepo();
        clickRepo();
        clickOnIssuesTab();
        issueNumberValidation();
    }
}
