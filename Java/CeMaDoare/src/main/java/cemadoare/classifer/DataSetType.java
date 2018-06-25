package cemadoare.classifer;

public enum DataSetType {

    STENOSIS, ARRYTHMIA, NONE;

    public DataSetType fromString(String value) {
        if ("stenosis".equalsIgnoreCase(value)) {
            return STENOSIS;
        } else if ("arrythmia".equalsIgnoreCase(value)) {
            return ARRYTHMIA;
        } else {
            return NONE;
        }
    }
}
