package jp.co.sample.form;

/**
 * 従業員更新時に使用するフォーム.
 * @author juri.saito
 *
 */
public class UpdateEmployeeForm {
	/** 従業員ID */
	private String id;
	/** 扶養人数 */
	private String dependentCount;
	
	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentCount=" + dependentCount + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDependentCount() {
		return dependentCount;
	}
	public void setDependentCount(String dependentCount) {
		this.dependentCount = dependentCount;
	}
	
	
}
