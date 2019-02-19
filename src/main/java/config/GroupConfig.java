package config;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@ConfigurationProperties("group")
public class GroupConfig {
    private boolean needSendFullMessage;
    private List<String> mailList;
    private List<Match> matchList;
    private BoolQueryBuilder queryFilter = null;

    public GroupConfig() {
        boolean x = true;
    }

    public GroupConfig(
            boolean needSendFullMessage,
            List<String> mailList,
            List<Match> matchList
    ) {
        this.needSendFullMessage = needSendFullMessage;
        this.mailList = mailList;
        this.matchList = matchList;
    }

    public List<String> getMailList() {
        return mailList;
    }

    public void setMailList(List<String> mailList) {
        this.mailList = mailList;
    }

    public void setNeedSendFullMessage(boolean needSendFullMessage) {
        this.needSendFullMessage = needSendFullMessage;
    }

    public boolean getNeedSendFullMessage() {
        return this.needSendFullMessage;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }

    private BoolQueryBuilder getFilter() {
        if (this.queryFilter == null && this.matchList != null) {
            this.queryFilter = QueryBuilders.boolQuery();
            for (Match match: this.matchList){
                this.queryFilter = queryFilter.must(
                        QueryBuilders.matchQuery(
                                match.getFieldName(),
                                match.getFieldValue()
                        )
                );
            }
        }
        return this.queryFilter;
    }

    public String toString() {

        return "needSendFullMessage = " + this.needSendFullMessage + '\n' +
                "mailList = " + this.mailList.toString() + '\n' +
                "matchList = " + this.matchList.toString() + '\n' +
                "filter = " + this.getFilter().toString() + '\n';
    }

    public static class Match {
        private String fieldName;
        private String fieldValue;


        public void setFieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
        }

        Object getFieldValue() {
            return fieldValue;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        String getFieldName() {
            return fieldName;
        }

        public Match() {
        }

        public Match(String fieldName, String fieldValue) {
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }

        public String toString() {
            return "\nthis.fieldName = " + this.fieldName + '\n' +
                    "this.fieldValue = " + this.fieldValue + '\n';
        }
    }
}
