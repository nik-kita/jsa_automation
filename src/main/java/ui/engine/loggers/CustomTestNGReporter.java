package ui.engine.loggers;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomTestNGReporter implements IReporter {

    //This is the customize emailabel report template file path.
    private static final String emailableReportTemplateFile = "src/main/resources/customize-emailable-report-template.html";
    String outputDirectory = "";

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        this.outputDirectory = outputDirectory;

        try
        {
            // Get content data in TestNG report template file.
            String customReportTemplateStr = this.readEmailabelReportTemplate() + this.getTestMehodSummary(suites);
            //=========================
            /**
             * Create all folders for suite, month, and day if they are not already created
             */
            String fileName = myFileTreeGeneratorBySuiteNames(suites);
            pathFolderFiller(fileName);
            String fileName2 = myFileTreeGeneratorByTime(suites);
            pathFolderFiller(fileName2);
            //=========================
            // Write replaced test report content to custom-emailable-report.html.
            File targetFile = new File(outputDirectory + "/" + fileName);
            FileWriter fw = new FileWriter(targetFile);
            fw.write(customReportTemplateStr);
            fw.flush();
            fw.close();
            /**
             * Repeat for another folder structure
             */
            File targetFile2 = new File(outputDirectory + "/" + fileName2);
            FileWriter fw2 = new FileWriter(targetFile2);
            fw2.write(customReportTemplateStr);
            fw2.flush();
            fw2.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    /* Read template content. */
    private String readEmailabelReportTemplate()
    {
        StringBuffer retBuf = new StringBuffer();
        try {
            File file = new File(this.emailableReportTemplateFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line!=null)
            {
                retBuf.append(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }finally
        {
            return retBuf.toString();
        }
    }
    /* Build custom report title. */
    private String getCustomReportTitle(String title)
    {
        StringBuffer retBuf = new StringBuffer();
        retBuf.append(title + " " + this.getDateInStringFormat(new Date()));
        return retBuf.toString();
    }
    /* Build test suite summary data. */


    /* Get date string format value. */
    private String getDateInStringFormat(Date date)
    {
        StringBuffer retBuf = new StringBuffer();
        if(date==null)
        {
            date = new Date();
        }
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        retBuf.append(df.format(date));
        return retBuf.toString();
    }
    /* Get test method summary info. */
    private String getTestMehodSummary(List<ISuite> suites)
    {
        StringBuffer retBuf = new StringBuffer();
        try
        {
            for(ISuite tempSuite: suites)
            {
                Map<String, ISuiteResult> testResults = tempSuite.getResults();
                for (ISuiteResult result : testResults.values()) {
                    ITestContext testObj = result.getTestContext();
                    String testName = testObj.getName();
                    /* Get failed test method related data. */
                    IResultMap testFailedResult = testObj.getFailedTests();
                    String failedTestMethodInfo = this.getTestMethodReport(testName, testFailedResult, false, false);
                    retBuf.append(failedTestMethodInfo);
                    /* Get skipped test method related data. */
                    IResultMap testSkippedResult = testObj.getSkippedTests();
                    String skippedTestMethodInfo = this.getTestMethodReport(testName, testSkippedResult, false, true);
                    retBuf.append(skippedTestMethodInfo);
                    /* Get passed test method related data. */
                    IResultMap testPassedResult = testObj.getPassedTests();
                    String passedTestMethodInfo = this.getTestMethodReport(testName, testPassedResult, true, false);
                    retBuf.append(passedTestMethodInfo);
                }
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            return retBuf.toString();
        }
    }
    /* Get failed, passed or skipped test methods report. */
    private String getTestMethodReport(String testName, IResultMap testResultMap, boolean passedReault, boolean skippedResult)
    {
        StringBuffer retStrBuf = new StringBuffer();
        String resultTitle = testName;
        Set<ITestResult> testResultSet = testResultMap.getAllResults();
        for(ITestResult testResult : testResultSet)
        {
            String reporterMessage = "";
            String exceptionMessage = "";
            List<String> repoterMessageList = Reporter.getOutput(testResult);
            for(String tmpMsg : repoterMessageList)
            {
                reporterMessage += "<p>";
                reporterMessage += tmpMsg;
                reporterMessage += "</p>";
            }
            //Get exception message.
            Throwable exception = testResult.getThrowable();
            if(exception!=null)
            {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                exception.printStackTrace(pw);
                exceptionMessage = sw.toString();
            }

            retStrBuf.append(reporterMessage);
            retStrBuf.append(exceptionMessage);
        }
        return retStrBuf.toString();
    }
    public String myFileTreeGeneratorBySuiteNames(List<ISuite> suites) {
        String suiteName = "/sort_by_suiteNames/";
        String and = "_and_";
        for(ISuite s : suites) {
            suiteName += s.getName() + and;
        }
        suiteName = suiteName.substring(0, suiteName.length() - and.length()) + "/";
        String date = new SimpleDateFormat("MMMM/dd_EEEE/$HH|mm|ss").format(new Date(System.currentTimeMillis()));
        int index = date.indexOf("$");
        String timeFolders = "/" + date.substring(0, index);
        String originalName = date.substring(index + 1);
        return (suiteName + timeFolders + originalName + ".html").replaceAll("\\s", "_");
//        return (timeFolders + suiteName + originalName + ".html").replaceAll("\\s", "_");
    }
    public String myFileTreeGeneratorByTime(List<ISuite> suites) {
        String date = new SimpleDateFormat("MMMM/dd_EEEE/$HH|mm|ss").format(new Date(System.currentTimeMillis()));
        int index = date.indexOf("$");
        String timeFolders = "/sort_by_time/" + date.substring(0, index);
        String originalName = date.substring(index + 1);

        String suiteName = "/";
        String and = "_and_";
        for(ISuite s : suites) {
            suiteName += s.getName() + and;
        }
        suiteName = suiteName.substring(0, suiteName.length() - and.length()) + "/";
        return (timeFolders + suiteName + originalName + ".html").replaceAll("\\s", "_");
    }

    public void pathFolderFiller(String fileName){
        String path = "";
        Matcher m = Pattern.compile("\\d{1,2}\\|\\d{1,2}\\|\\d{1,2}.").matcher(fileName);
        if(m.find()) {
            int index = m.start();
            path = outputDirectory + fileName.substring(0, index);
        }
        File directory = new File(path);
        if(!directory.exists()) {
            directory.mkdirs();
        }
    }

}
