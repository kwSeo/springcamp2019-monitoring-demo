# springcamp2019-monitoring-demo
Spring Camp 2019에서 'Monitoring With Actuator' 발표에서 설명한 Spring Boot Actuator와 Micromter의 예제 코드입니다.
간단한 책과 관련된 API를 제공하는 기본적인 Spring Boot 웹 애플리케이션입니다.
각 예제별로 브렌치가 나누어져 있습니다.

- master
  - 아무런 모니터링 설정이 없는 기본 코드
- actuator
  - spring-boot-starter-actuator 적용
- micrometer-registry
  - Prometheus와 Atlas로 모니터링하기 위해서 micrometer-registry 적용
- custom_metrics_counter_gauge
  - Micromter를 이용하여 Counter와 Gauge 커스텀 메트릭 생성
- custom_metrics_timer
  - Micromter를 이용하여 Timer 커스텀 메트릭 생성
- http_histogram
  - HTTP SLA, Histogram 등 설정
- meter_registry_customizer
  - MeterRegistryCostomizer 설정
- no_boot
  - Spring Boot AutoConfiguration없이 Micrometer 



