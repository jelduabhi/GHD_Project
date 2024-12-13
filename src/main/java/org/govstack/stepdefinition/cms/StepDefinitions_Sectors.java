package org.govstack.stepdefinition.cms;

import io.cucumber.java.en.When;
import org.govstack.pom.bd.bdSectors.pages.BDSectorsPage;

public class StepDefinitions_Sectors {

    BDSectorsPage bdSectorPg = new BDSectorsPage();

    @When("user Go to Sectors tab")
    public void user_go_to_sectors_tab() {
        bdSectorPg.bdSectorsTab();
    }
}
