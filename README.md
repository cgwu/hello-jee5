hello-jee5
==========
java EE 5 test project

Build Command:
mvn clean package -Dmaven.test.skip

start-cgdb.bat
cd ..\data
@java -classpath ../lib/hsqldb.jar org.hsqldb.server.Server --database.1 file:cgdb --dbname.1 cgdb


Jetty设置临时目录:
http://dev.eclipse.org/mhonarc/lists/jetty-users/msg01998.html
You have few choices.

1) Specify your own java.io.tmpdir java system property location for jetty to use.
    $ java -Djava.io.tmpdir=/path/to/my/new/temp/ -jar start.jar

2) Create a "work" directory under the ${jetty.home} path (whereever that is).
    That will cause Jetty to use that work directory instead of whatever the java.io.tmpdir property is set to.

3) Specify the tempDir attribute on the WebAppProvider deployments.
    Only valid for war file deployment scenarios, NOT valid for context based deployment.
    If you have etc/jetty-webapps.xml in your start.ini you have war file deployments enabled.
    Edit the ${jetty.home}/etc/jetty-webapps.xml file and add 1 more attribute on the WebAppProvider.
    <Set name="tempDir">/path/to/my/preferred/temp/dir/for/all/webapps</Set>

4) Set the tempDirectory attribute on the WebAppContext with context based deployments.
    NOT valid for war file deployment scenarios.
    If you have etc/jetty-context.xml in your start.ini you have context based deployments enabled.
    Edit the ${jetty.home}/contexts/myapp.xml and add the tempDirectory attribute on the WebAppContext.
    <Set name="tempDirectory">/path/to/my/preferred/temp/dir/for/this/context</Set>

Note: the servlet context attribute "javax.servlet.context.tempdir" can be used by your webapp to find out temp directory path is being used for the webapp.
Unfortunately, you cannot use this servlet context in your web.xml to set the tempdir as by the time this value is read from the web.xml it is too late in 
the deployment process to affect this settings (in other words ... the webapp has already been unpacked into the temp directory before this context attribute
 is even read)


<!-- jetty 实验成功-->
			<plugin>
				<groupId>org.mortbay.jetty</groupId>
				<artifactId>jetty-maven-plugin</artifactId>
				<version>${jetty.version}</version>
				<configuration>
					<!-- 每n秒扫描项目的文件改动，包括java类文件;若为0，一改动保存则重启jetty  -->
					<scanIntervalSeconds>0</scanIntervalSeconds>
					<stopPort>9999</stopPort>
					<webApp>
						<contextPath>/hello-jee5</contextPath>
					</webApp>
					<!-- 指定额外需要监控变化的文件或文件夹，主要用于热部署中的识别文件更新 -->  
                    <!-- <scanTargetPatterns>  
                        <scanTargetPattern>  
                            <directory>src</directory>  
                            <includes>  
                                <include>**/*.java</include>  
                                <include>**/*.properties</include>  
                            </includes>
							<excludes>
								<exclude>**/*.xml</exclude>
								<exclude>**/myspecial.properties</exclude>
							</excludes> 
                        </scanTargetPattern>  
                    </scanTargetPatterns> -->  
					 <connectors>
				       <connector implementation="org.eclipse.jetty.server.nio.SelectChannelConnector">
				       		<!-- 配置 jetty启动端口，或 mvn jetty:run -Djetty.port=1111 -->
				          <port>3333</port>
				          <maxIdleTime>60000</maxIdleTime>
				       </connector>
				     </connectors>
				     <webAppSourceDirectory>${basedir}/src/main/webapp</webAppSourceDirectory>
				</configuration>
			</plugin>  
			

