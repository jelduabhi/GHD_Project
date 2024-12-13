set timestamp=%date:~-4,4%-%date:~-10,4%_%time:~0,2%-%time:~3,2%-%time:~6,2%
allure generate --single-file allure-results -o AllureReports/allure-report_%timestamp%