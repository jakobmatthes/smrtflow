/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.pacbio.common.models.contracts;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ResolvedToolContract extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ResolvedToolContract\",\"namespace\":\"com.pacbio.common.models.contracts\",\"fields\":[{\"name\":\"resolved_tool_contract\",\"type\":{\"type\":\"record\",\"name\":\"ResolvedToolContractTask\",\"fields\":[{\"name\":\"input_files\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"output_files\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"options\",\"type\":{\"type\":\"map\",\"values\":[\"long\",\"boolean\",\"string\",\"int\"]},\"doc\":\"Resolved Task Options\"},{\"name\":\"nproc\",\"type\":\"int\"},{\"name\":\"is_distributed\",\"type\":\"boolean\"},{\"name\":\"task_type\",\"type\":\"string\"},{\"name\":\"tool_contract_id\",\"type\":\"string\"},{\"name\":\"resources\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}},{\"name\":\"driver\",\"type\":{\"type\":\"record\",\"name\":\"Driver\",\"fields\":[{\"name\":\"exe\",\"type\":\"string\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public com.pacbio.common.models.contracts.ResolvedToolContractTask resolved_tool_contract;
  @Deprecated public com.pacbio.common.models.contracts.Driver driver;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ResolvedToolContract() {}

  /**
   * All-args constructor.
   */
  public ResolvedToolContract(com.pacbio.common.models.contracts.ResolvedToolContractTask resolved_tool_contract, com.pacbio.common.models.contracts.Driver driver) {
    this.resolved_tool_contract = resolved_tool_contract;
    this.driver = driver;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return resolved_tool_contract;
    case 1: return driver;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: resolved_tool_contract = (com.pacbio.common.models.contracts.ResolvedToolContractTask)value$; break;
    case 1: driver = (com.pacbio.common.models.contracts.Driver)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'resolved_tool_contract' field.
   */
  public com.pacbio.common.models.contracts.ResolvedToolContractTask getResolvedToolContract() {
    return resolved_tool_contract;
  }

  /**
   * Sets the value of the 'resolved_tool_contract' field.
   * @param value the value to set.
   */
  public void setResolvedToolContract(com.pacbio.common.models.contracts.ResolvedToolContractTask value) {
    this.resolved_tool_contract = value;
  }

  /**
   * Gets the value of the 'driver' field.
   */
  public com.pacbio.common.models.contracts.Driver getDriver() {
    return driver;
  }

  /**
   * Sets the value of the 'driver' field.
   * @param value the value to set.
   */
  public void setDriver(com.pacbio.common.models.contracts.Driver value) {
    this.driver = value;
  }

  /** Creates a new ResolvedToolContract RecordBuilder */
  public static com.pacbio.common.models.contracts.ResolvedToolContract.Builder newBuilder() {
    return new com.pacbio.common.models.contracts.ResolvedToolContract.Builder();
  }
  
  /** Creates a new ResolvedToolContract RecordBuilder by copying an existing Builder */
  public static com.pacbio.common.models.contracts.ResolvedToolContract.Builder newBuilder(com.pacbio.common.models.contracts.ResolvedToolContract.Builder other) {
    return new com.pacbio.common.models.contracts.ResolvedToolContract.Builder(other);
  }
  
  /** Creates a new ResolvedToolContract RecordBuilder by copying an existing ResolvedToolContract instance */
  public static com.pacbio.common.models.contracts.ResolvedToolContract.Builder newBuilder(com.pacbio.common.models.contracts.ResolvedToolContract other) {
    return new com.pacbio.common.models.contracts.ResolvedToolContract.Builder(other);
  }
  
  /**
   * RecordBuilder for ResolvedToolContract instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ResolvedToolContract>
    implements org.apache.avro.data.RecordBuilder<ResolvedToolContract> {

    private com.pacbio.common.models.contracts.ResolvedToolContractTask resolved_tool_contract;
    private com.pacbio.common.models.contracts.Driver driver;

    /** Creates a new Builder */
    private Builder() {
      super(com.pacbio.common.models.contracts.ResolvedToolContract.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.pacbio.common.models.contracts.ResolvedToolContract.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.resolved_tool_contract)) {
        this.resolved_tool_contract = data().deepCopy(fields()[0].schema(), other.resolved_tool_contract);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.driver)) {
        this.driver = data().deepCopy(fields()[1].schema(), other.driver);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ResolvedToolContract instance */
    private Builder(com.pacbio.common.models.contracts.ResolvedToolContract other) {
            super(com.pacbio.common.models.contracts.ResolvedToolContract.SCHEMA$);
      if (isValidValue(fields()[0], other.resolved_tool_contract)) {
        this.resolved_tool_contract = data().deepCopy(fields()[0].schema(), other.resolved_tool_contract);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.driver)) {
        this.driver = data().deepCopy(fields()[1].schema(), other.driver);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'resolved_tool_contract' field */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask getResolvedToolContract() {
      return resolved_tool_contract;
    }
    
    /** Sets the value of the 'resolved_tool_contract' field */
    public com.pacbio.common.models.contracts.ResolvedToolContract.Builder setResolvedToolContract(com.pacbio.common.models.contracts.ResolvedToolContractTask value) {
      validate(fields()[0], value);
      this.resolved_tool_contract = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'resolved_tool_contract' field has been set */
    public boolean hasResolvedToolContract() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'resolved_tool_contract' field */
    public com.pacbio.common.models.contracts.ResolvedToolContract.Builder clearResolvedToolContract() {
      resolved_tool_contract = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'driver' field */
    public com.pacbio.common.models.contracts.Driver getDriver() {
      return driver;
    }
    
    /** Sets the value of the 'driver' field */
    public com.pacbio.common.models.contracts.ResolvedToolContract.Builder setDriver(com.pacbio.common.models.contracts.Driver value) {
      validate(fields()[1], value);
      this.driver = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'driver' field has been set */
    public boolean hasDriver() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'driver' field */
    public com.pacbio.common.models.contracts.ResolvedToolContract.Builder clearDriver() {
      driver = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public ResolvedToolContract build() {
      try {
        ResolvedToolContract record = new ResolvedToolContract();
        record.resolved_tool_contract = fieldSetFlags()[0] ? this.resolved_tool_contract : (com.pacbio.common.models.contracts.ResolvedToolContractTask) defaultValue(fields()[0]);
        record.driver = fieldSetFlags()[1] ? this.driver : (com.pacbio.common.models.contracts.Driver) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
