package org.govstack.stepdefinition.bd;

import io.cucumber.java.en.Then;
import org.govstack.framework.TestData;
import org.govstack.pom.bd.bdSectors.pages.BDSectorsPage;


public class StepDefinitions_Sectors {

    BDSectorsPage bdSectorPg=new BDSectorsPage();


        @Then("search sectors with existing record {string}")
        public void search_sectors_with_existing_record(String testcaseID) {
            TestData.readTestData(testcaseID, "BD_Sectors");
            bdSectorPg.bdSectorsSearchAssertion();
        }

        @Then("verify that radio button should be changed either to enabled or disable when user clicked")
        public void verify_that_radio_button_should_be_changed_either_to_enabled_or_disable_when_user_clicked() {
            bdSectorPg.bdSectorToggleValidation();
        }

        @Then("verify that user able to expand and collapse sector in grid")
        public void verify_that_user_able_to_expand_and_collapse_sector_in_grid() {
            bdSectorPg.bdSectorExpandCollapseValidation();
        }

        @Then("expand the sector list")
        public void expand_the_sector_list() {
            bdSectorPg.bdSectorsExpandGrid();
        }

        @Then("click area of service button")
        public void click_area_of_service_button() {
            bdSectorPg.bdAreaOfServiceBtn();
        }

        @Then("create new sector {string}")
        public void create_new_sector(String testcaseID) {
            TestData.readTestData(testcaseID, "BD_Sectors");
            bdSectorPg.bdCreateAreaOfSector();
        }

        @Then("verify sector is created")
        public void verify_sector_is_created() {
            bdSectorPg.bdSectorCreationValidation();
        }

        @Then("click delete button from grid")
        public void click_delete_button_from_grid() {
            bdSectorPg.bdSectorDeleteBtn();
        }

        @Then("click edit icon")
        public void click_edit_icon() {
            bdSectorPg.bdSectorEditBtn();
        }
        @Then("edit the record {string}")
        public void edit_the_record(String testcaseID) {
            TestData.readTestData(testcaseID, "BD_Sectors");
            bdSectorPg.bdEditAreaOfSector();
        }
        @Then("verify sector is updated")
        public void verify_sector_is_updated() {
            bdSectorPg.bdSectorUpdationValidation();
        }
}
