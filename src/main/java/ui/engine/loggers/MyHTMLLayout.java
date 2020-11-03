package ui.engine.loggers;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.html.DefaultThrowableRenderer;
import ch.qos.logback.classic.pattern.MDCConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.Layout;
import ch.qos.logback.core.helpers.Transform;
import ch.qos.logback.core.html.HTMLLayoutBase;
import ch.qos.logback.core.html.IThrowableRenderer;
import ch.qos.logback.core.pattern.Converter;

import java.util.Map;

import static ch.qos.logback.core.CoreConstants.LINE_SEPARATOR;

public class MyHTMLLayout extends HTMLLayoutBase<ILoggingEvent> implements Layout<ILoggingEvent> {
    static final String TRACE_PREFIX = "<br />&nbsp;&nbsp;&nbsp;&nbsp;";
    IThrowableRenderer<ILoggingEvent> throwableRenderer;
    static final String DEFAULT_CONVERSION_PATTERN = "%date%thread%level%logger%mdc%msg";

    public MyHTMLLayout() {
        pattern = DEFAULT_CONVERSION_PATTERN;
        throwableRenderer = new DefaultThrowableRenderer();
        cssBuilder = sbuf -> sbuf.append("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
        throwableRenderer = (sbuf, event) -> {
            IThrowableProxy tp = event.getThrowableProxy();
            String id = "id" + tp.hashCode();
            sbuf.append("<tr><td class=\"Exception\" colspan=\"6\"><a class=\"btn btn-primary\" data-toggle=\"collapse\" href=\"#").append(id).append("\" role=\"button\" aria-expanded=\"false\" aria-controls=\"").append(id).append("\">");
            while (tp != null) {
                render(sbuf, tp, id);
                tp = tp.getCause();
            }

        };
    }

    void render(StringBuilder sbuf, IThrowableProxy tp, String id) {
        printFirstLine(sbuf, tp);
        sbuf.append("<div class=\"collapse\" id=\"").append(id).append("\">");
        sbuf.append("<div class=\"card card-body\">");
        int commonFrames = tp.getCommonFrames();
        StackTraceElementProxy[] stepArray = tp.getStackTraceElementProxyArray();

        for (int i = 0; i < stepArray.length - commonFrames; i++) {
            StackTraceElementProxy step = stepArray[i];
            sbuf.append(TRACE_PREFIX);
            sbuf.append(Transform.escapeTags(step.toString()));
            sbuf.append(CoreConstants.LINE_SEPARATOR);
        }


        if (commonFrames > 0) {
            sbuf.append(TRACE_PREFIX);
            sbuf.append("\t... ").append(commonFrames).append(" common frames omitted").append(CoreConstants.LINE_SEPARATOR);
        }
        sbuf.append("</div></div>");
        sbuf.append("</tr></td>");
    }

    public void printFirstLine(StringBuilder sb, IThrowableProxy tp) {
        sb.append(tp.getClassName()).append(": ").append(Transform.escapeTags(tp.getMessage()));
        sb.append("</a>");
    }

    @Override
    protected Map<String, String> getDefaultConverterMap() {
        return PatternLayout.defaultConverterMap;
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        StringBuilder buf = new StringBuilder();
        this.startNewTableIfLimitReached(buf);

        boolean odd = true;
        if (((counter++) & 1) == 0) {
            odd = false;
        }

        String level = event.getLevel().toString().toLowerCase();

        buf.append(LINE_SEPARATOR);
        buf.append("<tr class=\"");
        buf.append(level);
        if (odd) {
            buf.append(" odd\">");
        } else {
            buf.append(" even\">");
        }
        buf.append(LINE_SEPARATOR);

        Converter<ILoggingEvent> c = head;
        while (c != null) {
            appendEventToBuffer(buf, c, event);
            c = c.getNext();
        }
        buf.append("</tr>");
        buf.append(LINE_SEPARATOR);

        if (event.getThrowableProxy() != null) {
            throwableRenderer.render(buf, event);
        }
        return buf.toString();
    }

    private void appendEventToBuffer(StringBuilder buf, Converter<ILoggingEvent> c, ILoggingEvent event) {
        buf.append("<td class=\"");
        buf.append(computeConverterName(c));
        buf.append("\">");
        buf.append(Transform.escapeTags(c.convert(event)));
        buf.append("</td>");
        buf.append(LINE_SEPARATOR);
    }

    public IThrowableRenderer getThrowableRenderer() {
        return throwableRenderer;
    }

    public void setThrowableRenderer(IThrowableRenderer<ILoggingEvent> throwableRenderer) {
        this.throwableRenderer = throwableRenderer;
    }

    @Override
    protected String computeConverterName(Converter c) {
        if (c instanceof MDCConverter) {
            MDCConverter mc = (MDCConverter) c;
            String key = mc.getFirstOption();
            if (key != null) {
                return key;
            } else {
                return "MDC";
            }
        } else {
            return super.computeConverterName(c);
        }
    }


    @Override
    public String getFileHeader() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("<!doctype html>");
        sbuf.append(LINE_SEPARATOR);
        sbuf.append("<html lang=\"en\">");
        sbuf.append(LINE_SEPARATOR);
        sbuf.append("  <head>");
        sbuf.append(LINE_SEPARATOR);
        sbuf.append("    <title>");
        sbuf.append(title);
        sbuf.append("</title>");
        sbuf.append(LINE_SEPARATOR);

        cssBuilder.addCss(sbuf);
//        sbuf.append("<!-- Bootstrap CSS -->\"+\n" +
//                "                \"    <link rel=\\\"stylesheet\\\" href=\\\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\\\" integrity=\\\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\\\" crossorigin=\\\"anonymous\\\">\"+\n" +
//                "                \"  ");

        sbuf.append(LINE_SEPARATOR);
        sbuf.append("  </head>");
        sbuf.append(LINE_SEPARATOR);
        sbuf.append("<body>");
        sbuf.append(LINE_SEPARATOR);
        sbuf.append("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\" crossorigin=\"anonymous\"></script>\n" +
                "\n");
        sbuf.append("</body></html>");


        return sbuf.toString();
    }

    public void buildHeaderRowForTable(StringBuilder sbuf) {
        Converter c = head;
        String name;
        sbuf.append("<tr class=\"header\">");
        sbuf.append(LINE_SEPARATOR);
        while (c != null) {
            name = computeConverterName(c);
            if (name == null) {
                c = c.getNext();
                continue;
            }
            sbuf.append("<td class=\"");
            sbuf.append(computeConverterName(c));
            sbuf.append("\">");
            sbuf.append(computeConverterName(c));
            sbuf.append("</td>");
            sbuf.append(LINE_SEPARATOR);
            c = c.getNext();
        }
        sbuf.append("</tr>");
        sbuf.append(LINE_SEPARATOR);
    }

    @Override
    public String getPresentationHeader() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("<hr/>");
        sbuf.append(LINE_SEPARATOR);
        sbuf.append("<p>Log session start time ");
        sbuf.append(new java.util.Date());
        sbuf.append("</p><p></p>");
        sbuf.append(LINE_SEPARATOR);
        sbuf.append(LINE_SEPARATOR);
        sbuf.append("<table class=\"table table-borderless table-dark\" cellspacing=\"0\">");
        sbuf.append(LINE_SEPARATOR);

        buildHeaderRowForTable(sbuf);

        return sbuf.toString();
    }

    @Override
    public String getFileFooter() {
        StringBuilder sbuf = new StringBuilder();
        sbuf.append(LINE_SEPARATOR);

        return sbuf.toString();
    }
}
