package if12.onekey_triage;

import hudson.model.Run;
import jenkins.model.Jenkins;
import jenkins.model.JenkinsLocationConfiguration;
import jenkins.model.RunAction2;

import java.net.MalformedURLException;
import java.net.URL;

import hudson.model.AbstractProject;
import hudson.model.Action;


public class TriageAction implements Action {
    private String name;

    public TriageAction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
	private String query;
	private String page;
	private String displayName;
    
    public TriageAction(String tab, String query, String displayName) {
        this.query = query;
        this.page = tab;
        this.displayName = displayName;
    }
    
    @Override
    public String getIconFileName() {
    		return Messages.triageIconName();    		
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String getUrlName() {
    		
        return Messages.artsServer() + page + "?" + query;
    }

}

