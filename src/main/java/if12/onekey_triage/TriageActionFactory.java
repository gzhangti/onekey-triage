package if12.onekey_triage;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import if12.onekey_triage.utils.LogEventHelper;
import javax.annotation.Nonnull;

import java.net.MalformedURLException;
import java.net.URL;


import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.Job;
import hudson.model.Run;
import hudson.model.TransientProjectActionFactory;
import jenkins.model.Jenkins;
import jenkins.model.JenkinsLocationConfiguration;
import jenkins.model.TransientActionFactory;

@Extension
public class TriageActionFactory extends TransientActionFactory<Run> {
	
	@Override
    public Class<Run> type() {
        return Run.class;
    }

    @Nonnull
    @Override
    public Collection<? extends Action> createFor(@Nonnull Run target) {
        Job job = target.getParent();
        Jenkins jenkins = Jenkins.getInstance();
		String host = "";
		String url = "";
		if (jenkins == null) {
			url = "";
		}
		else{
			url = jenkins.getRootUrl();
		}
		if (!url.startsWith("http://localhost")) {
			try {
		        host =  (new URL(url)).getHost();
		    } catch (MalformedURLException e) {
		    }
		}
		host = host.replaceAll(".sv.splunk.com", "");

		if (!host.endsWith("jenkins")){
			host = "sandbox";
		}
		
		LogEventHelper.UrlQueryBuilder builder=new LogEventHelper.UrlQueryBuilder()
				.putIfAbsent("form.product", Messages.product())
				.putIfAbsent("form.multi_source", host)
                .putIfAbsent("form.job_name", job.getFullName())
                .putIfAbsent("form.build_token", target.getNumber() + "");
		
        String query =builder.build();
		
        //String query = "form.job_name=" + job.getFullName() + "&form.product=splunk&form.multi_source=" + host + "&form.build_token=" + target.getNumber();
        return Collections.singleton(new TriageAction("triage", query, Messages.displayName()));
    }
}
