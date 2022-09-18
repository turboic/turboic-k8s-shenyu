Warning  FailedScheduling  7s (x4 over 2m16s)  default-scheduler  0/1 nodes are available: 1 node(s) had volume node affinity conflict.

  local:
    path: /home/k8s-pv  # 指定节点上的目录,该目录下面需要包含 mysql-connector.jar
  nodeAffinity:
    required:
      nodeSelectorTerms:
      - matchExpressions:
        - key: kubernetes.io/hostname
          operator: In
          values:
          - liebe # 指定节点,单节点部署的主机名称
		  
		  

mkdir  -p /home/mysql-pv

mkdir  -p /home/k8s-pv



创建mysql的数据库 demo utf8的编码
