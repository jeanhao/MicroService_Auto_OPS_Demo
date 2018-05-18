docker login --username=$1 registry.cn-hongkong.aliyuncs.com -p $2
docker build -t  registry.cn-hongkong.aliyuncs.com/jeanheo/api_proxy ./APIProxy
docker push registry.cn-hongkong.aliyuncs.com/jeanheo/api_proxy
docker build -t  registry.cn-hongkong.aliyuncs.com/jeanheo/client_demo ./ClientDemo
docker push registry.cn-hongkong.aliyuncs.com/jeanheo/client_demo
docker build -t  registry.cn-hongkong.aliyuncs.com/jeanheo/eureka_server ./EurekaServer
docker push registry.cn-hongkong.aliyuncs.com/jeanheo/eureka_server
docker build -t  registry.cn-hongkong.aliyuncs.com/jeanheo/loadbalance_demo ./LoadBalanceDemo
docker push registry.cn-hongkong.aliyuncs.com/jeanheo/loadbalance_demo
