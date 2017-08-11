package com.mclem.repositories;

import com.mclem.entities.Data;
import com.mclem.entities.DataDate;
import com.mclem.entities.IdentityWildcard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
@Import(MongoTestConfiguration.class)
public class IdentityWildcardRepositoryTest {

    @Autowired private MongoTemplate mongoTemplate;
    @Autowired private IdentityWildcardRepository identityWildcardRepository;

    @Test
    public void test_findOne_ReturnsTypedData() {
        DataDate dataDate = new DataDate();
        dataDate.setValue(LocalDate.of(2017, 8, 11));
        IdentityWildcard identity = new IdentityWildcard();
        identity.setId("123");
        identity.setData(dataDate);
        mongoTemplate.insert(identity);

        IdentityWildcard dbIdentity = identityWildcardRepository.findOne("123");

        Data data = dbIdentity.getData();
        assertThat(data, instanceOf(DataDate.class));
        assertThat(data.getValue(), instanceOf(LocalDate.class));
        assertEquals(LocalDate.of(2017, 8, 11), data.getValue());
    }

}