# Veteriner Yönetim Sistemi

Veteriner yönetim sistemi projesi, bir veteriner kliniğinin kendi işlerini yönetebilmesi için geliştirilmiş bir API'dır. Bu proje, veteriner çalışanları tarafından kullanılmak üzere tasarlanmıştır. Veteriner kliniği personeli, bu uygulama aracılığıyla çeşitli işlemleri gerçekleştirebilir.

## Proje Amaçları

- Veteriner doktorlarının kaydedilmesi ve çalışma günlerinin belirlenmesi
- Müşterilerin kaydedilmesi ve müşterilere ait hayvanların yönetilmesi
- Hayvanlara uygulanan aşıların kaydedilmesi ve yönetilmesi
- Veteriner hekimlere randevu oluşturulması ve randevuların yönetilmesi

## Projede Bulunan Entityler

### Animal (Hayvan)
- id:Long
- name:String
- species:String
- breed:String
- gender:String
- colour:String
- dateOfBirth:LocalDate

### Customer (Müşteri)
- id:Long
- name:String
- phone:String
- mail: String
- address:String
- city:String

### Vaccine (Aşı)
- id: Long
- name: String
- code: String
- protectionStartDate: LocalDate
- protectionFinishDate: LocalDate

### Doctor (Veteriner Hekim)
- id:Long
- name:String
- phone:String
- mail: String
- address:String
- city:String

### AvailableDate (Müsait Günler)
- id:Long
- availableDate:LocalDate

### Appointment (Randevu)
- id:Long
- appointmentDate:LocalDateTime

## API Temel Özellikleri

### Hayvanların ve Sahiplerinin Yönetimi
- Hayvanları ve sahiplerini kaydetme, güncelleme, görüntüleme ve silme
- Hayvan sahiplerini isme göre filtreleme
- Hayvanları isme göre filtreleme
- Bir hayvan sahibinin tüm kayıtlı hayvanlarını görüntüleme

### Uygulanan Aşıların Yönetimi
- Hayvanlara aşı kaydetme, güncelleme, görüntüleme ve silme
- Belirli bir hayvana ait tüm aşı kayıtlarını listeleme
- Aşı koruyuculuk bitiş tarihi yaklaşan hayvanları listeleme

### Randevu Yönetimi
- Hayvanların aşı ve muayene randevularının oluşturulması, güncellenmesi, görüntülenmesi ve silinmesi
- Randevuların tarih ve saat içerecek şekilde kaydedilmesi
- Doktorların müsait günleri doğrultusunda randevu oluşturulması
- Randevuların tarih aralığına ve doktora göre filtrelenmesi
- Randevuların tarih aralığına ve hayvana göre filtrelenmesi

### Veteriner Doktor Yönetimi
- Veteriner doktorların kaydedilmesi, güncellenmesi, görüntülenmesi ve silinmesi

### Doktorların Müsait Günlerinin Yönetimi
- Doktorların müsait günlerinin ekleme, güncelleme, görüntüleme ve silinmesi

## Teknolojiler
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

## Kurulum
1. Proje dosyalarını bilgisayarınıza indirin.
2. Projeyi bir Java IDE'sinde (IntelliJ IDEA, Eclipse vb.) açın.
3. Projeyi çalıştırın.
4. browser üzerinden http://localhost:8080/swagger-ui/index.html adresine gidin.
5. API'ye erişim sağlayın ve belirtilen işlemleri gerçekleştirin.

## Lisans
Bu proje MIT lisansı altında lisanslanmıştır. Detaylı bilgi için [LICENSE](LICENSE) dosyasına bakınız.
