package phoenix.api.service;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public interface DatabaseService {

    default Collection collection(String collection) {
        return new Collection(getMongoOperations().getCollection(collection));
    }

    MongoOperations getMongoOperations();

    class DocumentBuilder {

        private final Document document = new Document();

        public DocumentBuilder add(String key, Object value) {
            this.document.put(key, value);
            return this;
        }

        public Document get() {
            return this.document;
        }

    }

    class Collection {

        private final MongoCollection<Document> document;

        Collection(MongoCollection<Document> document) {
            this.document = document;
        }

        public QueryResult find(String key, Object value) {
            return new QueryResult(document.find(new BasicDBObject(key, value)));
        }

        public boolean exists(String key, Object value) {
            return find(key, value).one() != null;
        }

        public void insert(Document... document) {
            this.document.insertMany(Arrays.asList(document));
        }

        public MongoCollection<Document> getDocument() {
            return document;
        }

        public DocumentBuilder document() {
            return new DocumentBuilder();
        }

        public static class QueryResult {

            private final FindIterable<Document> result;

            QueryResult(FindIterable<Document> result) {
                this.result = result;
            }

            public Document one() {
                AtomicReference<Document> result = new AtomicReference<>();
                this.result.forEach(result::set);
                return result.get();
            }

            public void all(Consumer<Document> consumer) {
                this.result.forEach(consumer);
            }

        }

    }

}
