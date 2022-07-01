# SOA_04_14
Dịch vụ đăng ký thuê oxy cho bệnh viện xây dựng bằng Spring boot và Eureka
Dịch vụ bao gồm:
    1 service registry sử dụng eureka để quản lý, đặt tên cho các service
    1 utility service notification để gửi mail thông báo đăng ký thuê oxy thành công
    3 entity service: BenhVien, Oxy, DonDangky
Cài đặt môi trường:
    B1: Cài đặt spring tool suite https://spring.io/tools
    B2: Cài đặt môi trường java
    B3: Cài đặt MySQL
Chạy chương trình:
    B1: Start discovery server
    B2: Start các service: Task service, Utility Service, Entity Service
    B3: Chạy trên cổng 8761 để thấy các dịch vụ đang chạy + http://localhost:8761/
    B4: Chạy Client trên cổng 8088 + http://localhost:8088/thueoxy/dondangky
    B5: Thực hiện đăng ký thuê oxy
