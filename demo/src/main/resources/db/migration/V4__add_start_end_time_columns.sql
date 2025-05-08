-- V4: يضيف العمودَين بجملتين منفصلتين لأن H2 لا يقبل الفاصلة بعد IF NOT EXISTS

ALTER TABLE bookings
    ADD COLUMN IF NOT EXISTS start_time TIMESTAMP NOT NULL;

ALTER TABLE bookings
    ADD COLUMN IF NOT EXISTS end_time   TIMESTAMP NOT NULL;
