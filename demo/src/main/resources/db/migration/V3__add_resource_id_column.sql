-- يضيف العمود resource_id إذا لم يكن موجوداً
ALTER TABLE bookings
    ADD COLUMN IF NOT EXISTS resource_id BIGINT NOT NULL;

-- تأكد من وجود الفهرس (اختياري)
CREATE INDEX IF NOT EXISTS idx_bookings_resource
    ON bookings (resource_id);
