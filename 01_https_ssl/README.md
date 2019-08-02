https/ssl/tls basic 
1. `https://www.tutorialsteacher.com/https`

Get free ssl certificates using let's encrypt (CA) `https://certbot.eff.org/lets-encrypt/centos6-nginx` :
1. Install Certbot
```shell
wget https://dl.eff.org/certbot-auto
sudo mv certbot-auto /usr/local/bin/certbot-auto
sudo chown root /usr/local/bin/certbot-auto
sudo chmod 0755 /usr/local/bin/certbot-auto
```

2. Get certificate
```shell
sudo /usr/local/bin/certbot-auto certonly --nginx
```

Do as instructions told to get certficates for domains certbot found in nginx virtual host configs. After finish, this note will appear:

```
IMPORTANT NOTES:
 - Congratulations! Your certificate and chain have been saved at:
   /linktofullchain/fullchain.pem
   Your key file has been saved at:
   /linktoprivatekey/privkey.pem
   Your cert will expire on 2019-10-30. To obtain a new or tweaked
   version of this certificate in the future, simply run certbot-auto
   again. To non-interactively renew *all* of your certificates, run
   "certbot-auto renew"
```   

Take note these 2 certificates:
certificate
- `/linktofullchain/fullchain.pem`
private key
- `/linktoprivatekey/privkey.pem`

3. Add to nginx virtual host:
Change server_name, ssl_certificate, ssl_certificate_key, proxy_pass value accordingly to your configuration.

```
server {
  listen 443 ssl;
  server_name example.com
  access_log off;
  error_log /etc/nginx/logs/adjust_callback.log;
  ssl_certificate "/linktofullchain/fullchain.pem";
  ssl_certificate_key "/linktoprivatekey/privkey.pem";
  location / {
    proxy_pass http://127.0.0.1:9119;
  }
}
```

4. Restart nginx

5. Confirm result by using `https://www.ssllabs.com/ssltest/`

6. Set crontab job for automatic renewal:
```shell
echo "0 0,12 * * * root python -c 'import random; import time; time.sleep(random.random() * 3600)' && /usr/local/bin/certbot-auto renew" | sudo tee -a /etc/crontab > /dev/null
```
