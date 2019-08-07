# Notification

### [What is push notification](https://onesignal.com/what-are-push-notifications)
<img src="https://www.tune.com/tune-com-content/uploads/2017/02/21-Pg-iphone.jpg" width="200px">

### How does it work?
#### Notification services
- [APNS](https://developer.apple.com/library/archive/documentation/NetworkingInternet/Conceptual/RemoteNotificationsPG/APNSOverview.html)
- [GCM](https://developers.google.com/cloud-messaging/) (Deprecated)
- [FCM](https://firebase.google.com/docs/cloud-messaging/)

<img src="https://developer.apple.com/library/archive/documentation/NetworkingInternet/Conceptual/RemoteNotificationsPG/Art/token_generation_2x.png" width="500px">
- When app start, application connect to push notification service and use certificate to get notification token.
- The app send this token to server side application.


<img src="https://developer.apple.com/library/archive/documentation/NetworkingInternet/Conceptual/RemoteNotificationsPG/Art/token_trust_2x.png" width="500px">
- Server send message to push notification service, then the message will be delivered to device.

#### Third party services
- [AWS Simple Notification Service (SNS)](https://aws.amazon.com/sns/) (*)
- [Firebase Cloud Message (FCM)](https://firebase.google.com/docs/cloud-messaging/) (*)
- [One Signal](https://onesignal.com/)
- And more

|                   | SNS | FCM |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------------|-----------------------------|
|       Company     |                                                     Amazon                                                                        | Google                      |
|       Pricing     | First 1 million Amazon SNS requests per month are free<br>$0.50 per 1 million Amazon SNS requests thereafter<br>Data transfer fee | Free                        |
|Supported platforms| iOS, Android, Fire OS, Windows and Baidu                                                                                          | iOS, Android, C++, Unity, **Web**|
|Platform-Specific Message| Yes																															| Yes
|Supported type     | Single device, Topic																												| Single device, **Group device**, Topic
|      Limitation   | 256KB																																| 4KB						  |
