/**
 * User: Srinu Kusumanchi s3810121
 * Created Date: 2022-08-14
 * Created Time: 1:32 p.m.
 */

package bns.a6.microui.web.cucumber;

import java.util.Objects;

public final class ScenarioContext {

    public String scenarioId;
    public String tableName;
    private static ScenarioContext INSTANCE = null;
    private ScenarioContext(){

    }

    public String getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }



    public static synchronized ScenarioContext getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new ScenarioContext();
        }
        return INSTANCE;
    }
}
