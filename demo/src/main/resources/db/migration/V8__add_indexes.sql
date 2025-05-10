-- V8__add_indexes.sql   ← النسخة النهائية
-------------------------------------------------------------
-- Composite index يسرّع findByUserIdAndStatus
CREATE INDEX idx_bookings_user_status  ON bookings (user_id, status);

-- Index للترتيب أو الاستعلام حسب created_at
CREATE INDEX idx_bookings_created_at   ON bookings (created_at);

