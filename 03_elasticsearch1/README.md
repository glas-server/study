# Elasticsearch

### What is elasticsearch
A distributed, open source search and analytics engine for all types of data, including textual, numerical, geospatial, structured, and unstructured, built on Apache Lucene.

- Apache Lucene: is a Java full-text search engine. Lucence is not a complete application, but rather a code library and API that can easily be used  to add search capabilities to application.
(https://lucene.apache.org/core/)
 
- Elasticsearch: 
is a search engine based on Lucence. It provides a distributed, multiplenamt-capable full-text search engine with an HTTP web interface and schema-free JSON documents.
(https:/medium.com/@udayms/elasticsearch-reactjs-fd5059140760)
# Advantages and disadvantages: 
(https://interviewbubble.com/elasticsearch-pros-and-cons-advantages-and-disadvantages-of-elasticsearch/
	https://viblo.asia/p/elasticsearch-la-gi-1Je5E8RmlnL)
 => Integrating Elastic Search With Mongodb
 (https://medium.com/@AzilenTech/integrating-elastic-search-with-mongodb-using-no-sql-6e67a8172a5a)
 
### Basic concepts:
Index
Type
Document
Cluster
Node
Shard

(https://viblo.asia/p/elasticsearch-cac-khai-niem-co-ban-phan-1-m68Z0O2jKkG
https://viblo.asia/p/elasticsearch-distributed-search-ZnbRlr6lG2Xo
https://github.com/TrongTan124/ghi-chep-ELK-OPS/blob/master/read-Elasticsearch-the-definitive-guide.md).
		
### Inverted Index
(https://dammayxanh.wordpress.com/2017/11/22/full-text-search-bap-be-hoc-interted-index/)

# Search in elasticsearch:
- Native API: use socket to connect client-server, default port 9300 (high performance), support for multi program language: Java, Js,..
- Restfull API: default port 9200, based on HTTP
	CRUD through Restful API: 
	
		curl -X<VERB> '<PROTOCOL>://<HOST>/<PATH>?<QUERY_STRING>' -d '<BODY>‘
	
		- VERB: method of HTTP: GET , POST , PUT , HEAD or DELETE 
		- PROTOCOL: http or https
		- HOST: host name or IP of ES server
		- PORT: default 9200.
		- QUERY_STRING: query-string parameters (Example ?pretty )
		- BODY: body of request with type JSON object.
	
### Query DSL
- Leaf query clauses
- Compound query clauses
(https://viblo.asia/p/query-dsl-trong-elasticsearch-Eb85oJq2l2G)

