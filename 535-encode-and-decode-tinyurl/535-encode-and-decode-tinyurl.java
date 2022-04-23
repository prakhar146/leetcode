public class Codec {
    Map<String, String> tinyMap;
    
    Codec() {
        tinyMap = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int resourcePathIdx = indexOfResourcePath(longUrl);
        String baseUrl = longUrl.substring(0, resourcePathIdx);
        String urlPath = longUrl.substring(resourcePathIdx);
        String encodedUrlPath = String.valueOf(urlPath.hashCode());
         
        tinyMap.put(encodedUrlPath, urlPath);
        String tinyUrl = baseUrl + encodedUrlPath;
        
        return tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int resourcePathIdx = indexOfResourcePath(shortUrl);
        String baseUrl = shortUrl.substring(0, resourcePathIdx);
        String urlPath = shortUrl.substring(resourcePathIdx);
        
        String decodedUrlPath = tinyMap.get(urlPath);
        
        String longUrl = baseUrl + decodedUrlPath;
        return longUrl;
    }
    
    private int indexOfResourcePath(String url) {
        return url.indexOf("/", url.indexOf("//") + 2) + 1;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));