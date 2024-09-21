package com.gcp.service;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

@Service
public class GoogleStorageServiceImpl implements GoogleStorageService {

	@Autowired
	private Storage storage;

	@Value("${gcp.storage.bucketName}")
	private String bucketName;

	@Override
	public void create(MultipartFile file) throws IOException {

		BlobId blobId = BlobId.of("test-bucket", "testFile");
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

		byte[] arr = file.getBytes();

		storage.create(blobInfo, arr);
	}

	@Override
	public String readFile() {
		StringBuffer stringBuffer = new StringBuffer();
		try (ReadChannel readChannel = storage.reader(bucketName, "demofile.txt")){
			ByteBuffer byteBuffer = ByteBuffer.allocate(64 * 2024);
			while( readChannel.read(byteBuffer) > 0) {
				byteBuffer.flip();
				String data = new String(byteBuffer.array(), 0, byteBuffer.limit());
				stringBuffer.append(data);
				byteBuffer.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bucketName;
	}

}
