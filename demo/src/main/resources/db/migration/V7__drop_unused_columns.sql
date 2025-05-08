-- V7__cleanup_bookings_table.sql
-- حذف flight_id و seat_count وجعل booking_time قابلاً للإبقاء NULL

-- احذف FLIGHT_ID
ALTER TABLE bookings
    DROP COLUMN IF EXISTS flight_id;

-- احذف SEAT_COUNT
ALTER TABLE bookings
    DROP COLUMN IF EXISTS seat_count;

-- اجعل BOOKING_TIME اختيارياً (إن كان موجوداً)
ALTER TABLE bookings
    ALTER COLUMN booking_time SET NULL;
