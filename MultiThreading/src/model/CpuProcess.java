package model;

/**
 * Define process class with parameters, such as id and name
 * @author Tribel
 *
 */
public class CpuProcess {

	private int processId;
	private String name;
	
	/**
	 * Default constructor
	 */
	public CpuProcess() {
	}

	/**
	 * Constructor that define id and name of the process.
	 * @param processId int process identificator. 
	 * @param name {@link String} process name
	 */
	public CpuProcess(int processId, String name) {
		super();
		this.processId = processId;
		this.name = name;
		
		System.out.println("Creating new process");
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + processId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpuProcess other = (CpuProcess) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (processId != other.processId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CpuProcess [processId=" + processId + ", name=" + name + "]";
	}
	
	
}
