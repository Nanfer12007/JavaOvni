CREATE TABLE IF NOT EXISTS sightings (
    id BIGSERIAL PRIMARY KEY,
    location VARCHAR(255) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    color VARCHAR(80) NOT NULL,
    shape VARCHAR(20) NOT NULL,
    quantity INT NOT NULL CHECK (quantity >= 1)
);

CREATE INDEX IF NOT EXISTS idx_sightings_date_time ON sightings (date_time);
CREATE INDEX IF NOT EXISTS idx_sightings_shape ON sightings (shape);
