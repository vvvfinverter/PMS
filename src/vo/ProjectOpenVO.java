package vo;

public class ProjectOpenVO {
	String proName, proStart, proEnd, proState, teamName;	// 프젝명, 프젝시작, 프젝끝, 프젝진행여부, 팀명

	
	public ProjectOpenVO() {}
	
	public ProjectOpenVO(String proName, String proStart, String proEnd, String proState, String teamName) {
		this.proName = proName;
		this.proStart = proStart;
		this.proEnd = proEnd;
		this.proState = proState;
		this.teamName = teamName;
	}
	
	
	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProStart() {
		return proStart;
	}

	public void setProStart(String proStart) {
		this.proStart = proStart;
	}

	public String getProEnd() {
		return proEnd;
	}

	public void setProEnd(String proEnd) {
		this.proEnd = proEnd;
	}

	public String getProState() {
		return proState;
	}

	public void setProState(String proState) {
		this.proState = proState;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
	
}
