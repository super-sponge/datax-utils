package datax.utils.jobconf;

import com.fasterxml.jackson.annotation.JsonIgnore;
import datax.utils.hdfs.HRParameter;
import datax.utils.hdfs.HRReader;
import datax.utils.settings.JobSetting;
import datax.utils.stream.SWriter;

import java.util.ArrayList;
import java.util.List;

public class JobHdfsToStream {
    private static class Job {
        private static class Content {
            private HRReader reader = new HRReader();
            private SWriter writer = new SWriter();

            public HRReader getReader() {
                return reader;
            }

            public void setReader(HRReader reader) {
                this.reader = reader;
            }

            public SWriter getWriter() {
                return writer;
            }

            public void setWriter(SWriter writer) {
                this.writer = writer;
            }
        }

        private JobSetting setting = new JobSetting();
        private List<Content> content = new ArrayList<Content>(1);

        public Job() {
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
    private  Job job = new Job();

    public  Job getJob() {
        return this.job;
    }

    public  void setJob(Job job) {
        this.job = job;
    }

    @JsonIgnore
    public HRParameter getFirstReaderParameter() {
        Job.Content content = this.getJob().getContent().get(0);
        return  content.getReader().getParameter();
    }
}
