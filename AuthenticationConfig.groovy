/* SAML CONFIGURATIONS */
grails.plugin.springsecurity.saml.active=false
//grails.plugin.springsecurity.saml.user.idplookupfield='customproperty10'
grails.plugin.springsecurity.saml.userlookup='username,email'

grails.plugin.springsecurity.successHandler.alwaysUseDefault=false
grails.plugin.springsecurity.logout.postOnly=false 
grails.plugin.springsecurity.saml.alwaysUseAfterLoginUrl=false
grails.plugin.springsecurity.saml.defaultTargetUrl="/"
grails.plugin.springsecurity.saml.afterLoginUrl = '/home/dummyhome'
grails.plugin.springsecurity.saml.afterLogoutUrl = '/logout'
grails.plugin.springsecurity.saml.autoCreate.key='username'
grails.plugin.springsecurity.saml.userAttributeMappings=[]
grails.plugin.springsecurity.saml.userGroupToRoleMapping=[:]
grails.plugin.springsecurity.saml.userGroupAttribute=""
grails.plugin.springsecurity.saml.idpSelectionPath="/"
grails.plugin.springsecurity.saml.autoCreate.active = true
grails.plugin.springsecurity.saml.autoCreate.assignAuthorities=true

grails.plugin.springsecurity.saml.metadata.url = '/saml/metadata'
grails.plugin.springsecurity.saml.responseSkew=300
grails.plugin.springsecurity.saml.maxAuthenticationAge=1800

grails.plugin.springsecurity.saml.logouturl='/ECM/saml/logout?local=true'
grails.plugin.springsecurity.logout.afterLogoutUrl = '/logout/logout'

// SINGLE IDP START

// IDP-1
//grails.plugin.springsecurity.saml.metadata.defaultIdp='http://www.okta.com/exkc3gqyutbYX75cp0h7'
//grails.plugin.springsecurity.saml.metadata.providers = [ ping:'security/idp.xml' ]
//grails.plugin.springsecurity.saml.metadata.sp.file = 'security/sp-1.xml'
//grails.plugin.springsecurity.saml.metadata.sp.defaults.alias =  'testtwo'

// IDP-2
//grails.plugin.springsecurity.saml.metadata.providers = [ test: 'security/idp-new.xml' ]
//grails.plugin.springsecurity.saml.metadata.defaultIdp='http://www.okta.com/exkbjzuh6jjl7Srk80h7' 
//grails.plugin.springsecurity.saml.metadata.sp.file = 'security/sp.xml'
//grails.plugin.springsecurity.saml.metadata.sp.defaults.alias =  'testone'

// SINGLE IDP  END

// MULTIPLE IDP START
grails.plugin.springsecurity.saml.metadata.providers = [  okta1:'security/idp.xml' , okta2: 'security/idp-new.xml' ]
grails.plugin.springsecurity.saml.metadata.sp.file = [testone: 'security/sp.xml', testtwo: 'security/sp-1.xml']
grails.plugin.springsecurity.saml.metadata.sp.defaults.alias =  'testone1'

// Define all idps entity ID here
ecm.login.options = [
   "okta1" : "http://www.okta.com/xxxx" ,
   "okta2" : "http://www.okta.com/xxxx" 
]


// Displays popup values for customer , left side is the one which gets displayed 
// in popup, right one is key to ecm.login.options defined above
customer.domain.login.options = [
   "okta1.xxx.com" : "okta1",
   "okta2.xxx.com" : "okta2"
]

// Displays popup values for saviynt team , left side is the one which gets displayed 
// in popup, right one is key to ecm.login.options defined above
saviynt.domain.login.options = [
  "okta1.xxx.com" : "okta1" , 
  "okta2.xxx.com" : "okta2"
]




// MULTIPLE IDP END

/* SAML CONFIGURATIONS END*/


/* LDAP */
grails.plugin.springsecurity.ldap.active=false
grails.plugin.springsecurity.ldap.context.managerDn = 'cn=admin,cn=users,dc=corpAD,dc=saviynt,dc=com'
grails.plugin.springsecurity.ldap.context.managerPassword = 'xxxxxx'
grails.plugin.springsecurity.ldap.context.server = 'ldap://Saviyntcs.cloudapp.net:389' // if port 636 then ldaps
grails.plugin.springsecurity.ldap.authorities.ignorePartialResultException = true // typically needed for Active Directory
grails.plugin.springsecurity.ldap.search.base = 'cn=users,dc=corpAD,dc=saviynt,dc=com'
grails.plugin.springsecurity.ldap.search.filter= "sAMAccountname={0}" // for Active Directory you need this
grails.plugin.springsecurity.ldap.search.searchSubtree = true
grails.plugin.springsecurity.ldap.auth.hideUserNotFoundExceptions = false
//grails.plugin.springsecurity.ldap.search.attributesToReturn = ['mail','displayName']
//grails.plugin.springsecurity.providerNames = ['ldapAuthProvider' , 'daoAuthenticationProvider' , 'anonymousAuthenticationProvider', 'rememberMeAuthenticationProvider'] // specify this when you want to skip attempting to load from db and only use LDAP
grails.plugin.springsecurity.ldap.mapper.userDetailsClass = 'com.saviynt.ecm.identitywarehouse.domain.Users'
//grails.plugin.springsecurity.userLookup.usernamePropertyName = 'systemUserName'
grails.plugin.springsecurity.ldap.useRememberMe = false
//grails.plugin.springsecurity.ldap.authorities.groupSearchBase = 'OU=US'
//grails.plugin.springsecurity.ldap.authorities.retrieveGroupRoles = false
grails.plugin.springsecurity.ldap.authorities.retrieveDatabaseRoles = true