/*
 * Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.spi.impl.discovery.HazelcastCloudDiscovery;
import com.hazelcast.client.spi.properties.ClientProperty;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * todo add proper javadoc
 */
public class Size {

    public static void main(String[] args) throws Exception {
        ClientConfig config = new ClientConfig();
        config.setGroupConfig(new GroupConfig("ali3", "80750413cb1f423e95d1eca88648a98b"));
        String token = "KTAp4sJrqX5dh7SmWHNXGpd6wy3OnyWhzq3SVVU7EJsn9ZDLsY";
        config.setProperty(ClientProperty.HAZELCAST_CLOUD_DISCOVERY_TOKEN.getName(), token);
        config.setProperty(HazelcastCloudDiscovery.CLOUD_URL_BASE_PROPERTY.getName(), "https://dev.hazelcast.cloud");
//        config.getNetworkConfig().addAddress("34.220.136.2:31748");
//        config.getNetworkConfig().setSmartRouting(false);
//        config.getNetworkConfig().setSSLConfig(new SSLConfig().setEnabled(true));
        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);
        IMap<Integer, byte[]> map = client.getMap("map2");

        while (true) {
            System.out.println(map.size());
            Thread.sleep(1000);
        }
    }
}
