CREATE DATABASE IF NOT EXISTS vedatban
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `vedatban`.`reservation_event` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Khóa chính',
    `name` VARCHAR(50) NOT NULL COMMENT 'Tên sự kiện đặt bàn',
    `description` TEXT COMMENT 'Mô tả sự kiện',
    `start_time` DATETIME NOT NULL COMMENT 'Thời gian bắt đầu mở đặt bàn',
    `end_time` DATETIME NOT NULL COMMENT 'Thời gian kết thúc đặt bàn',
    `status` INT(11) NOT NULL DEFAULT 0 COMMENT 'Trạng thái hoạt động (0: ngừng, 1: đang hoạt động)',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm cập nhật gần nhất',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm tạo',
    PRIMARY KEY (`id`),
    KEY `idx_end_time` (`end_time`),
    KEY `idx_start_time` (`start_time`),
    KEY `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Bảng sự kiện đặt bàn';

CREATE TABLE IF NOT EXISTS `vedatban`.`table_slot` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Khóa chính',
    `name` VARCHAR(50) NOT NULL COMMENT 'Tên bàn hoặc khu vực',
    `description` TEXT COMMENT 'Mô tả bàn/khu vực',
    `capacity_initial` INT(11) NOT NULL DEFAULT 0 COMMENT 'Sức chứa ban đầu (ví dụ: 10 chỗ)',
    `capacity_available` INT(11) NOT NULL DEFAULT 0 COMMENT 'Sức chứa còn trống hiện tại',
    `is_prepared` BOOLEAN NOT NULL DEFAULT 0 COMMENT 'Đã được chuẩn bị sẵn sàng (0/1)',
    `price_regular` BIGINT(20) NOT NULL COMMENT 'Giá đặt bàn bình thường',
    `price_discount` BIGINT(20) NOT NULL COMMENT 'Giá ưu đãi trong khung giờ vàng',
    `slot_start_time` DATETIME NOT NULL COMMENT 'Thời gian bắt đầu đặt slot',
    `slot_end_time` DATETIME NOT NULL COMMENT 'Thời gian kết thúc slot',
    `status` INT(11) NOT NULL DEFAULT 0 COMMENT 'Trạng thái hoạt động của bàn',
    `event_id` BIGINT(20) NOT NULL COMMENT 'ID của sự kiện liên kết',
    `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm cập nhật',
    `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm tạo',
    PRIMARY KEY (`id`),
    KEY `idx_slot_end_time` (`slot_end_time`),
    KEY `idx_slot_start_time` (`slot_start_time`),
    KEY `idx_status` (`status`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Chi tiết bàn trong sự kiện';


CREATE TABLE IF NOT EXISTS `vedatban`.`reservation_order_202502` (
    id INT(8) NOT NULL AUTO_INCREMENT COMMENT 'ID đơn đặt bàn',
    user_id INT(8) NOT NULL COMMENT 'ID người đặt',
    order_number VARCHAR(50) NOT NULL COMMENT 'Mã đơn đặt chỗ',
    total_amount DECIMAL(10,3) NOT NULL COMMENT 'Tổng chi phí',
    terminal_id VARCHAR(20) NOT NULL COMMENT 'ID điểm bán (POS)',
    order_date TIMESTAMP NOT NULL COMMENT 'Thời điểm đặt bàn',
    order_notes VARCHAR(100) DEFAULT 'Không có ghi chú' COMMENT 'Ghi chú thêm',
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Cập nhật lần cuối',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Tạo lúc',
    PRIMARY KEY (id) USING BTREE,
    UNIQUE KEY order_number (order_number),
    KEY order_date (order_date),
    KEY index_usr_id (user_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Đơn đặt bàn';

CREATE TABLE IF NOT EXISTS `vedatban`.`reservation_order_detail_202502` (
    id INT(8) NOT NULL AUTO_INCREMENT COMMENT 'ID chi tiết đơn',
    table_slot_id BIGINT(20) NOT NULL COMMENT 'ID bàn đã đặt',
    order_number VARCHAR(50) NOT NULL COMMENT 'Tham chiếu đến mã đơn',
    guest_name VARCHAR(100) NOT NULL COMMENT 'Tên khách tham dự',
    guest_id VARCHAR(20) NOT NULL COMMENT 'CMND/CCCD hoặc hộ chiếu',
    table_location VARCHAR(50) NOT NULL COMMENT 'Khu vực bàn (ví dụ: sảnh A)',
    seat_number VARCHAR(10) NOT NULL COMMENT 'Số ghế',
    arrival_time DATETIME NOT NULL COMMENT 'Thời gian đến dự kiến',
    seat_type ENUM('Thường', 'VIP', 'VIP Đặc biệt') NOT NULL COMMENT 'Loại ghế',
    price_per_seat DECIMAL(10,3) NOT NULL COMMENT 'Giá từng chỗ',
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời gian cập nhật',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Thời điểm tạo',
    PRIMARY KEY (id) USING BTREE,
    KEY order_number (order_number),
    KEY table_slot_id (table_slot_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'Chi tiết đơn đặt bàn';

-- INSERT DATA
INSERT INTO `vedatban`.`reservation_event` (`name`, `description`, `start_time`, `end_time`, `status`)
VALUES
    ('Gala Dinner 12/12', 'Sự kiện Gala Dinner đặc biệt ngày 12/12', '2024-12-12 00:00:00', '2024-12-12 23:59:59', 1),
    ('Tiệc Mừng Năm Mới 01/01', 'Sự kiện đón năm mới tại nhà hàng', '2025-01-01 00:00:00', '2025-01-01 23:59:59', 1);

INSERT INTO `vedatban`.`table_slot` (`name`, `description`, `capacity_initial`, `capacity_available`, `is_prepared`, `price_regular`, `price_discount`, `slot_start_time`, `slot_end_time`, `status`, `event_id`)
VALUES
    ('Bàn Phổ Thông - Gala 12/12', 'Bàn thường tại Gala Dinner 12/12', 10, 10, 0, 1000000, 800000, '2024-12-12 18:00:00', '2024-12-12 22:00:00', 1, 1),
    ('Bàn VIP - Gala 12/12', 'Bàn VIP cho Gala Dinner', 5, 5, 0, 2000000, 1500000, '2024-12-12 18:00:00', '2024-12-12 22:00:00', 1, 1),
    ('Bàn Phổ Thông - Tiệc 01/01', 'Bàn thường ngày Tết', 20, 20, 0, 1000000, 800000, '2025-01-01 18:00:00', '2025-01-01 22:00:00', 1, 2),
    ('Bàn VIP - Tiệc 01/01', 'Bàn VIP ngày Tết', 10, 10, 0, 2000000, 1500000, '2025-01-01 18:00:00', '2025-01-01 22:00:00', 1, 2);

INSERT INTO `vedatban`.`reservation_order_202502` (order_number, user_id, total_amount, terminal_id, order_date, order_notes)
VALUES ('RES2025020001', 1001, 5600000, 'POS001', '2025-02-28 10:00:00', 'Tiệc gia đình');

INSERT INTO `vedatban`.`reservation_order_detail_202502`
(table_slot_id, order_number, guest_name, guest_id, table_location, seat_number, arrival_time, seat_type, price_per_seat)
VALUES
    (4, 'RES2025020001', 'Nguyen Van A', 'ID12345678', 'Sảnh VIP', 'A1', '2025-03-01 18:00:00', 'Thường', 1400000),
    (4, 'RES2025020001', 'Nguyen Van B', 'ID12345679', 'Sảnh VIP', 'A2', '2025-03-01 18:00:00', 'Thường', 1400000),
    (4, 'RES2025020001', 'Nguyen Van C', 'ID12345680', 'Sảnh VIP', 'A3', '2025-03-01 18:00:00', 'Thường', 1400000),
    (4, 'RES2025020001', 'Nguyen Van D', 'ID12345681', 'Sảnh VIP', 'A4', '2025-03-01 18:00:00', 'Thường', 1400000);

