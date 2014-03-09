exec { "apt-get update":
  path => "/usr/bin",
}

package { 'openjdk-7-jre-headless':
}

package { 'libtcnative':
   name => 'libtcnative-1',
}

package { 'authbind':
}

package { 'tomcat7': 
   ensure => installed,
   require => [
      Package['openjdk-7-jre-headless'],
      Package['authbind'],
      Package['libtcnative'],
    ],
}

service { 'tomcat7':
   enable => true,
   ensure => running,
   require => Package['tomcat7'],
}
