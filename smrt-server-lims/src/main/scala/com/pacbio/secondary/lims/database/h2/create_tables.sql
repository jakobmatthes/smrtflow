CREATE TABLE IF NOT EXISTS LIMS_YML (
  id IDENTITY PRIMARY KEY, -- arbitrary primary ket ID
  expcode INT,
  runcode VARCHAR,
  path VARCHAR,
  user VARCHAR,
  uid VARCHAR,
  tracefile VARCHAR,
  description VARCHAR,
  wellname VARCHAR,
  cellbarcode VARCHAR,
  seqkitbarcode VARCHAR,
  cellindex VARCHAR,
  colnum VARCHAR,
  samplename VARCHAR,
  instid INT
);
-- this exists only in this service. arbitrary aliases or short codes
CREATE TABLE IF NOT EXISTS ALIAS (
  alias VARCHAR PRIMARY KEY,
  lims_yml_id INT
);