package datax.utils.jobconf;

import com.fasterxml.jackson.annotation.JsonIgnore;
import datax.utils.hdfs.HRParameter;
import datax.utils.hdfs.HRReader;
import datax.utils.oracle.ORParameter;
import datax.utils.oracle.OWriter;
import datax.utils.settings.JobSetting;

import java.util.ArrayList;
import java.util.List;

public class JobHdfsToOracle {
    private static class JobInternal {
        private static class Content {
            private HRReader reader = new HRReader();
            private OWriter writer = new OWriter();

            public HRReader getReader() {
                return reader;
            }

            public void setReader(HRReader reader) {
                this.reader = reader;
            }

            public OWriter getWriter() {
                return writer;
            }

            public void setWriter(OWriter writer) {
                this.writer = writer;
            }
        }

        private JobSetting setting = new JobSetting();
        private List<Content> content = new ArrayList<Content>(1);

        public JobInternal() {
            this.getContent().add(new Content());

        }
        public JobSetting getSetting() {
            return setting;
        }

        public void setSetting(JobSetting setting) {
            this.setting = setting;
        }

        public List<Content> getContent() {
            return content;
        }

        public void setContent(List<Content> content) {
            this.content = content;
        }
    }
    private JobInternal job = new JobInternal();

    public JobInternal getJob() {
        return this.job;
    }

    public  void setJob(JobInternal job) {
        this.job = job;
    }

    @JsonIgnore
    public HRParameter getFirstReaderParameter() {
        JobInternal.Content content = this.getJob().getContent().get(0);
        return  content.getReader().getParameter();
    }
    @JsonIgnore
    public ORParameter getWriterParameter() {
        JobInternal.Content content = this.getJob().getContent().get(0);
        return content.getWriter().getParameter();
    }
}
