-- يضيف total_price إن لم يكن موجوداً
ALTER TABLE bookings
    ADD COLUMN IF NOT EXISTS total_price DOUBLE NOT NULL DEFAULT 0;
