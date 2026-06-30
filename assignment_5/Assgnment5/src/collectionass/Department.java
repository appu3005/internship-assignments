package collectionass;

import java.util.Objects;

public class Department {

    private int deptId;
    private String deptName;

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    @Override
    public String toString() {
        return "Department [ID=" + deptId + ", Name=" + deptName + "]";
    }

    // prevent duplicate deptId in HashSet
    @Override
    public int hashCode() {
        return Objects.hash(deptId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Department other = (Department) obj;
        return deptId == other.deptId;
    }
}